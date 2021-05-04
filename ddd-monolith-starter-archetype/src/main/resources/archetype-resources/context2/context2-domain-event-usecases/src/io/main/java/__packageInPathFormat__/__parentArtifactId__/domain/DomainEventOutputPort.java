#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

import java.util.List;

public interface DomainEventOutputPort {
  
  public void writeCount(final long count);

  public void writeDomainEventList(
    List<DomainEventListItemDTO> aDomainEventListItemDTOList);
}
