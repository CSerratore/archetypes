#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.List;

interface EventStore {


  void append(final DomainEvent aDomainEvent);

  long countStoredEvents();

  List<StoredEvent> allStoredEvents();

  long getNextEventIdSequence();
  
}
