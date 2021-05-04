#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId};

import ${package}.${parentArtifactId}.domain.EntityIdOutputPort;
import ${package}.${parentArtifactId}.domain.EntityValueObjectQuery;
import ${package}.${parentArtifactId}.domain.ProvisionEntityCommand;
import ${package}.${parentArtifactId}.domain.ProvisionEntityUseCase;
import ${package}.${parentArtifactId}.domain.QueryEntityValueObjectUseCase;
import ${package}.${parentArtifactId}.domain.Registry;
import ${package}.${parentArtifactId}.domain.StdOutEntityIdOutputAdapter;
import ${package}.${parentArtifactId}.domain.StdOutValueObjectOutputAdapter;
import ${package}.${parentArtifactId}.domain.UpdateEntityValueObjectCommand;
import ${package}.${parentArtifactId}.domain.UpdateEntityValueObjectUseCase;
import ${package}.${parentArtifactId}.domain.ValueObjectOutputPort;

public class Console {
  public static void main(final String[] args) throws Exception {

    init();

    System.out.println("Bounded Context 1 System Console ready");

    provisionEntityUseCase.provisionEntity(
      new ProvisionEntityCommand("Hello", 111, true), 
      entityIdOutputPort);

    final String entityId = entityIdOutputPort.getEntityIdDTO().id;

    queryEntityValueObjectUseCase.queryEntityValueObject(
      new EntityValueObjectQuery(entityId), 
      valueObjectOutputPort);

    updateEntityValueObjectUseCase.updateEntityValueObject(
      new UpdateEntityValueObjectCommand(
        entityId, "Goodbye", 222, false));

    queryEntityValueObjectUseCase.queryEntityValueObject(
      new EntityValueObjectQuery(entityId), 
      valueObjectOutputPort);
    
  }

  private static void init() {
    Registry.init("${package}.${parentArtifactId}.domain.HashMapEntityRepository");
    provisionEntityUseCase = ProvisionEntityUseCase.build();
    queryEntityValueObjectUseCase = QueryEntityValueObjectUseCase.build();
    updateEntityValueObjectUseCase = UpdateEntityValueObjectUseCase.build();

    entityIdOutputPort = new StdOutEntityIdOutputAdapter();
    valueObjectOutputPort = new StdOutValueObjectOutputAdapter();
  }

  private static ProvisionEntityUseCase provisionEntityUseCase;
  private static QueryEntityValueObjectUseCase queryEntityValueObjectUseCase;
  private static UpdateEntityValueObjectUseCase updateEntityValueObjectUseCase;
  private static EntityIdOutputPort entityIdOutputPort;
  private static ValueObjectOutputPort valueObjectOutputPort;
}
