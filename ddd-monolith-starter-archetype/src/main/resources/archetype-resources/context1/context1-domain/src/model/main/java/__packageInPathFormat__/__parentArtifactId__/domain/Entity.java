#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.domain;


/**
 * A generic domain model Entity.
 * 
 */
class Entity {

  /**
   * A factory method to construct an Entity.
   * @return
   */
  static Entity build(final ValueObject aValueObject) {
    return new Entity(aValueObject);
  }

  
  /** 
   * Update the Entity's value object.
   * @param aValueObject
   */
  void updateValueObject(final ValueObject aValueObject) {
    this.valueObject = aValueObject;
  }
  
  /** 
   * Query the Entity's ID.
   * @return EntityId
   */
  EntityId id() {
    return id;
  }

  
  /** 
   * Query the Entity's value object.
   * @return ValueObject
   */
  ValueObject valueObject() {
    return valueObject;
  }



  
  private Entity(final ValueObject aValueObject) {
    this.id = EntityId.build();
    this.valueObject = aValueObject;
  }

  private final EntityId id;
  private ValueObject valueObject;
}