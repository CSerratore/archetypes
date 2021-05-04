#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.Date;

interface DomainEvent {
  Date occurredOn();
}
