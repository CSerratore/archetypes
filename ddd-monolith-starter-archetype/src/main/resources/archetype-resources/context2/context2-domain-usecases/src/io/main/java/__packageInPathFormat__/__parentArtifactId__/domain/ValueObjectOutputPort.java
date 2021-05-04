#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public interface ValueObjectOutputPort {
  
  public void write(ValueObjectDTO aValueObjectDTO);
}
