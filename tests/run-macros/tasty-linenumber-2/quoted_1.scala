import scala.quoted._

class LineNumber(val value: Int) {
  override def toString: String = value.toString
}

object LineNumber {

  implicit inline def line: LineNumber = ${lineImpl}

  def lineImpl(using QuoteContext) : Expr[LineNumber] = {
    import qctx.tasty._
    '{new LineNumber(${Expr(rootPosition.startLine)})}
  }

}
