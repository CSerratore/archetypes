#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DomainEventPublisher {

  private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
      protected DomainEventPublisher initialValue() {
          return new DomainEventPublisher();
      }
  };

  private boolean publishing;

  @SuppressWarnings("rawtypes")
  private List subscribers;

  static DomainEventPublisher instance() {
      return instance.get();
  }

  <T> void publish(final T aDomainEvent) {
      if (!this.isPublishing() && this.hasSubscribers()) {

          try {
              this.setPublishing(true);

              Class<?> eventType = aDomainEvent.getClass();

              @SuppressWarnings("unchecked")
              List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();

              for (DomainEventSubscriber<T> subscriber : allSubscribers) {
                  Class<?> subscribedToType = subscriber.subscribedToEventType();

                  if (eventType == subscribedToType || subscribedToType == DomainEvent.class) {
                      subscriber.handleEvent(aDomainEvent);
                  }
              }

          } finally {
              this.setPublishing(false);
          }
      }
  }

  void publishAll(Collection<DomainEvent> aDomainEvents) {
      for (DomainEvent domainEvent : aDomainEvents) {
          this.publish(domainEvent);
      }
  }

  void reset() {
      if (!this.isPublishing()) {
          this.setSubscribers(null);
      }
  }

  @SuppressWarnings("unchecked")
  <T> void subscribe(DomainEventSubscriber<T> aSubscriber) {
      if (!this.isPublishing()) {
          this.ensureSubscribersList();

          this.subscribers().add(aSubscriber);
      }
  }

  private DomainEventPublisher() {
      super();

      this.setPublishing(false);
      this.ensureSubscribersList();
  }

  @SuppressWarnings("rawtypes")
  private void ensureSubscribersList() {
      if (!this.hasSubscribers()) {
          this.setSubscribers(new ArrayList());
      }
  }

  private boolean isPublishing() {
      return this.publishing;
  }

  private void setPublishing(boolean aFlag) {
      this.publishing = aFlag;
  }

  private boolean hasSubscribers() {
      return this.subscribers() != null;
  }

  @SuppressWarnings("rawtypes")
  private List subscribers() {
      return this.subscribers;
  }

  @SuppressWarnings("rawtypes")
  private void setSubscribers(List aSubscriberList) {
      this.subscribers = aSubscriberList;
  }
}
