#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class QueryEntityValueObjectUseCase {

  public static QueryEntityValueObjectUseCase build() {
    return new QueryEntityValueObjectUseCase(Registry.entityRepository());
  }

  public void queryEntityValueObject(
    final EntityValueObjectQuery aQuery, 
    final ValueObjectOutputPort aValueObjectOutputPort) {

    final Entity entity = entityRepository.entityOfId(
      EntityId.fromString(aQuery.entityIdString));
      final ValueObject valueObject = entity.valueObject();

    aValueObjectOutputPort.write(
      new ValueObjectDTO(
        valueObject.stringProperty(),
        Integer.toString(valueObject.integerProperty()),
        Boolean.toString(valueObject.booleanProperty())));
  }

  private final EntityRepository entityRepository;

  private QueryEntityValueObjectUseCase(final EntityRepository anEntityRepository) {
    entityRepository = anEntityRepository;
  }
  
}