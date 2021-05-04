#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class StdOutEntityIdOutputAdapter implements EntityIdOutputPort {

  @Override
  public void write(EntityIdDTO anEntityIdDTO) {
    entityIdDTO = anEntityIdDTO;

    System.out.println(
      "${symbol_escape}"EntityId${symbol_escape}":${symbol_escape}"" + entityIdDTO.id + "${symbol_escape}"");
  }


  @Override
  public EntityIdDTO getEntityIdDTO() {
    return entityIdDTO;
  }

  private EntityIdDTO entityIdDTO;  
}
