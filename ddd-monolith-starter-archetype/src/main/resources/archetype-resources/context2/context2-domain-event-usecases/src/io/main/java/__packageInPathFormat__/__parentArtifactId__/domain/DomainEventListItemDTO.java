#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.Date;

public class DomainEventListItemDTO {

  public DomainEventListItemDTO(
    long anEventIdSequence,
    Date anOccurredOn,
    String aTypeName) {
    this.eventIdSequence = anEventIdSequence;
    this.occurredOn = anOccurredOn;
    this.typeName = aTypeName;
  }

  public long eventIdSequence;
  public Date occurredOn;
  public String typeName;

}
