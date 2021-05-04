#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public interface EntityIdOutputPort {

  public void write(EntityIdDTO anEntityIdDTO);

  public EntityIdDTO getEntityIdDTO();
  
}
