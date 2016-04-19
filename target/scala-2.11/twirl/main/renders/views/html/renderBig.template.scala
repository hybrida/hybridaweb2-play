
package renders.views.html

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
object renderBig extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*2.1*/("""<div class='col-lg-8 render big-thumbnail' style='padding: 7px; margin-bottom: -1px;'>
	<div class="white-box no-shadow">
		"""),_display_(/*4.4*/content),format.raw/*4.11*/("""
	"""),format.raw/*5.2*/("""</div>
</div>"""))}
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/renderBig.scala.html
                  HASH: 1b23daf5328c6f0a119e2dd272da3ac13bb6a4b5
                  MATRIX: 733->1|836->16|864->18|1016->145|1043->152|1072->155
                  LINES: 26->1|29->1|30->2|32->4|32->4|33->5
                  -- GENERATED --
              */
          