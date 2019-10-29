package net.emdal.tank

open class Node(val label: String) : Entity()

fun <T : Node> Graph.node(
  alias: String = "",
  node: T,
  block: T.() -> String = { "" }
): Graph = node(node, alias, block)

fun <T : Node> Graph.node(
  node: T,
  alias: String = "",
  block: T.() -> String = { "" }
): Graph {
  return this.copy(
    query = query + "($alias:${node.label} {${node.block()}})",
    aliases = aliases + (alias to node)
  )
}