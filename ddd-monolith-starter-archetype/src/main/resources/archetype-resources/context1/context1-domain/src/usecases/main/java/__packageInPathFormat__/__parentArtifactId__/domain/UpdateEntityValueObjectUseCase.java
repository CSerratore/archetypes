#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;

public class UpdateEntityValueObjectUseCase {

  public static UpdateEntityValueObjectUseCase build() {
      return new UpdateEntityValueObjectUseCase(Registry.entityRepository());
  }

  public void updateEntityValueObject(
     final UpdateEntityValueObjectCommand aCommand) {
    final Entity entity = entityRepository.entityOfId(
      EntityId.fromString(aCommand.entityIdString));
      
      entity.updateValueObject(
        ValueObject.build(
          aCommand.stringProperty, 
          aCommand.intProperty, 
          aCommand.booleanProperty));
  }

  private final EntityRepository entityRepository;

  private UpdateEntityValueObjectUseCase(final EntityRepository anEntityRepository) {
    this.entityRepository = anEntityRepository;
  }
  
}
