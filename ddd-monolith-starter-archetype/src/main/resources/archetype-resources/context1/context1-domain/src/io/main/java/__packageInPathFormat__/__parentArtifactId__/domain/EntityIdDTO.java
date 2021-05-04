#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class EntityIdDTO {

  public EntityIdDTO(String anEntityIdString) {
    this.id = anEntityIdString;
  }

  public String id;
}
