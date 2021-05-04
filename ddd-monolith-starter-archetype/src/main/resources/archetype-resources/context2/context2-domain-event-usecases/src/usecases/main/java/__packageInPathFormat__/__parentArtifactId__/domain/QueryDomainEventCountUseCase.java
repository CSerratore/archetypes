#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class QueryDomainEventCountUseCase {

  public static QueryDomainEventCountUseCase build() {
    return new QueryDomainEventCountUseCase(EventRegistry.eventStore());
  }  

  public void queryDomainEventCount(DomainEventOutputPort aDomainEventOutputPort) {
    aDomainEventOutputPort.writeCount(eventStore.countStoredEvents());
  }

  EventStore eventStore;
  
  private QueryDomainEventCountUseCase(final EventStore anEventStore) {
    this.eventStore = anEventStore;
  }
}
