#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

interface DomainEventSubscriber<T> {

  void handleEvent(final T aDomainEvent);
  
  Class<T> subscribedToEventType();
}