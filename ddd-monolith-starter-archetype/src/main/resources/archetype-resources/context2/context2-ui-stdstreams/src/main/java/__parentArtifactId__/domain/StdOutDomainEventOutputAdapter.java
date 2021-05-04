#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.List;

public class StdOutDomainEventOutputAdapter implements DomainEventOutputPort {

  @Override
  public void writeCount(final long count) {

    System.out.println(
      "${symbol_escape}"Count${symbol_escape}":" + count);
  }

  @Override
  public void writeDomainEventList(List<DomainEventListItemDTO> aDomainEventListItemDTOList) {
    for (DomainEventListItemDTO aListItem: aDomainEventListItemDTOList) {
      System.out.println(
        "${symbol_escape}"DomainEvent${symbol_escape}":{ " +
          "${symbol_escape}"eventIdSequence${symbol_escape}":" + aListItem.eventIdSequence + ", " +
          "${symbol_escape}"occurredOn${symbol_escape}":${symbol_escape}"" + aListItem.occurredOn.toString() + "${symbol_escape}", " +
          "${symbol_escape}"typeName${symbol_escape}":${symbol_escape}"" + aListItem.typeName + "${symbol_escape}" }");
    }
    
  }

}
