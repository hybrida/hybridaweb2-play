
package views.html.layoutinternals

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
object layoutWithHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(headContent: Html = null):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.58*/("""
"""),_display_(/*2.2*/internal/*2.10*/.main(title)/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""
	"""),_display_(/*3.3*/if(headContent != null && !headContent.equals(Html("")))/*3.59*/ {_display_(Seq[Any](format.raw/*3.61*/("""
		"""),_display_(/*4.4*/headContent),format.raw/*4.15*/("""
	""")))}),format.raw/*5.3*/("""
""")))}/*6.2*/ {_display_(Seq[Any](format.raw/*6.4*/("""
	"""),_display_(/*7.3*/internal/*7.11*/.navigationMenu()),format.raw/*7.28*/("""
	"""),_display_(/*8.3*/internal/*8.11*/.layoutTop()),format.raw/*8.23*/("""
	"""),_display_(/*9.3*/content),format.raw/*9.10*/("""
	"""),_display_(/*10.3*/internal/*10.11*/.layoutBottom()),format.raw/*10.26*/("""
""")))}),format.raw/*11.2*/("""
"""))}
  }

  def render(title:String,content:Html,headContent:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(headContent)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (headContent) => apply(title)(content)(headContent)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutinternals/layoutWithHead.scala.html
                  HASH: 98e23c7d8b941f9adf3864192913fdc271b32a21
                  MATRIX: 758->1|902->57|930->60|946->68|966->80|1005->82|1034->86|1098->142|1137->144|1167->149|1198->160|1231->164|1251->167|1289->169|1318->173|1334->181|1371->198|1400->202|1416->210|1448->222|1477->226|1504->233|1534->237|1551->245|1587->260|1620->263
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|33->5|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|38->10|38->10|38->10|39->11
                  -- GENERATED --
              */
          