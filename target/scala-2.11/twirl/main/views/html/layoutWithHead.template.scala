
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
object layoutWithHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(headContent: Html = null):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.58*/("""
"""),_display_(/*2.2*/layoutinternals/*2.17*/.layoutWithHead(title)/*2.39*/ {_display_(Seq[Any](format.raw/*2.41*/("""
	"""),_display_(/*3.3*/content),format.raw/*3.10*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
	"""),_display_(/*5.3*/headContent),format.raw/*5.14*/("""
""")))}),format.raw/*6.2*/("""
"""))}
  }

  def render(title:String,content:Html,headContent:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(headContent)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (headContent) => apply(title)(content)(headContent)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutWithHead.scala.html
                  HASH: f2f476e203c2738410f8e504908db9d50ec0c9f5
                  MATRIX: 742->1|886->57|914->60|937->75|967->97|1006->99|1035->103|1062->110|1082->113|1120->115|1149->119|1180->130|1212->133
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|31->3|31->3|32->4|32->4|33->5|33->5|34->6
                  -- GENERATED --
              */
          