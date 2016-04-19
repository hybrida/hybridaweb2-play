
package staticpages.views.html

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
object staticPageHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.47*/routes/*3.53*/.Assets.at("stylesheets/static-page.css")),format.raw/*3.94*/("""">
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/staticPageHead.scala.html
                  HASH: 6f42e15243f72ec219260532f57bf2772dd9677a
                  MATRIX: 737->1|826->3|856->7|928->53|942->59|1003->100
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3
                  -- GENERATED --
              */
          