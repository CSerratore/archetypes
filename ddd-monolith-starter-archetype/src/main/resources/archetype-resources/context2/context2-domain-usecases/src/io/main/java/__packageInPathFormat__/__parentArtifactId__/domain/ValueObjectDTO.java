#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class ValueObjectDTO {

  public ValueObjectDTO(
    String aStringValue,
    String anIntValue,
    String aBooleanValue) {
      this.stringValue = aStringValue;
      this.intValue = anIntValue;
      this.booleanValue = aBooleanValue;
    }

  public String stringValue;
  public String intValue;
  public String booleanValue;
}
