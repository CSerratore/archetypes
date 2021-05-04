#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

interface EntityRepository {

  void add(Entity anEntity);

  Entity entityOfId(EntityId anEntityId);
  
}
