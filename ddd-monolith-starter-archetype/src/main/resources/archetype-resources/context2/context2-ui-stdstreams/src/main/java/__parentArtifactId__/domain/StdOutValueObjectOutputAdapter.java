#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class StdOutValueObjectOutputAdapter implements ValueObjectOutputPort {

  @Override
  public void write(ValueObjectDTO aValueObjectDTO) {

    System.out.println(
      "${symbol_escape}"ValueObject${symbol_escape}":{ " +
        "${symbol_escape}"stringValue${symbol_escape}":${symbol_escape}"" + aValueObjectDTO.stringValue + "${symbol_escape}", " +
        "${symbol_escape}"intValue${symbol_escape}":" + String.valueOf(aValueObjectDTO.intValue) + ", " +
        "${symbol_escape}"booleanValue${symbol_escape}":" + String.valueOf(aValueObjectDTO.booleanValue) +
        " }");
  }
}
