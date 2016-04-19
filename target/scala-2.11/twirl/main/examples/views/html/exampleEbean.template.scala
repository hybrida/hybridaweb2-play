
package examples.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object exampleEbean extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.17*/("""

"""),format.raw/*4.1*/("""<h1>Ebean Example Page</h1>
<form name="input" action=""""),_display_(/*5.29*/examples/*5.37*/.controllers.routes.ExampleEbean.add()),format.raw/*5.75*/("""" method="POST">
    <input type="text" name="name">
    <input type="submit" name="create" value="Create entity">
</form>
<form name="input" action=""""),_display_(/*9.29*/examples/*9.37*/.controllers.routes.ExampleEbean.clear()),format.raw/*9.77*/("""" method="POST">
    <input type="submit" name="clear" value="Delete all">
</form>
"""),_display_(/*12.2*/content),format.raw/*12.9*/("""


"""))}
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/examples/views/exampleEbean.scala.html
                  HASH: ada155503b5560699553359c543ab54571179be1
                  MATRIX: 737->3|840->18|870->22|953->79|969->87|1027->125|1208->280|1224->288|1284->328|1397->415|1424->422
                  LINES: 26->2|29->2|31->4|32->5|32->5|32->5|36->9|36->9|36->9|39->12|39->12
                  -- GENERATED --
              */
          