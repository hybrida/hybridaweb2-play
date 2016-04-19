
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
object exampleCookies extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.17*/("""

"""),format.raw/*3.1*/("""<form action="/UpdateCookies" method="POST">
    <input type="text" name="key" required> <strong>Key (required)</strong> <br/>
    <input type="text" name="value"> <strong>Value</strong> <br/>
    <input type="submit" value="Create" name="button">
</form>
<form action="/ClearCookies" method="POST">
	<input type="submit" value="Clear">
</form>
<p style="color: white">"""),_display_(/*11.26*/message),format.raw/*11.33*/("""<p/>
"""))}
  }

  def render(message:Html): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/examples/views/exampleCookies.scala.html
                  HASH: 582a56b605a57530d55502cf40b03c7795e204a1
                  MATRIX: 739->1|842->16|872->20|1277->398|1305->405
                  LINES: 26->1|29->1|31->3|39->11|39->11
                  -- GENERATED --
              */
          