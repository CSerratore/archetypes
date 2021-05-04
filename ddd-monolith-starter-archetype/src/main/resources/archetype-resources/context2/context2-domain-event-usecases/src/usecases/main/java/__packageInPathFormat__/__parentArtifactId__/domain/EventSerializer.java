#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

interface EventSerializer {

  String serialize(DomainEvent aDomainEvent);

  <T extends DomainEvent> T deserialize(String aSerialization, final Class<T> aType);
}
