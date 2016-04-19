
package views.html

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
object layoutBoxPage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(/*3.2*/layoutWithHead(title)/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    """),format.raw/*4.5*/("""<div class="container-fluid center-container space-above space-below">
        <div class="col-md-12 page-box" style="text-align: center">
        """),_display_(/*6.10*/content),format.raw/*6.17*/("""
        """),format.raw/*7.9*/("""</div>
    </div>
""")))}/*9.2*/ {_display_(Seq[Any](format.raw/*9.4*/("""
""")))}))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutBoxPage.scala.html
                  HASH: 360ae0e4a4024cdd32a579b87ef7dac306fa6c5f
                  MATRIX: 736->1|854->31|884->36|913->57|952->59|984->65|1160->215|1187->222|1223->232|1261->253|1299->255
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|34->6|34->6|35->7|37->9|37->9
                  -- GENERATED --
              */
          