package net.emdal.tank

open class Relationship(val name: String) : Entity()

fun <T : Relationship> Graph.relationship(
  alias: String = "",
  madeFrom: T,
  block: T.() -> String = { "" }
): Graph = relationship(madeFrom, alias, block)

fun <T : Relationship> Graph.relationship(
  relationship: T,
  alias: String = "",
  block: T.() -> String = { "" }
): Graph {
  return this.copy(
    query = query + "-[$alias:${relationship.name} {${relationship.block()}}]->",
    aliases = aliases + (alias to relationship)
  )
}