#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class EntityValueObjectQuery {
    
  public EntityValueObjectQuery(final String anEntityIdString) {
    this.entityIdString = anEntityIdString;
  }

  public final String entityIdString;
}
