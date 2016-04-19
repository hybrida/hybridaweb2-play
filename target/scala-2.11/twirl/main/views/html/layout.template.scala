
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
object layout extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""
"""),_display_(/*2.2*/layoutinternals/*2.17*/.layoutWithHead(title)/*2.39*/(content)/*2.48*/(null)),format.raw/*2.54*/("""
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,content)

  def f:((String,Html) => play.twirl.api.HtmlFormat.Appendable) = (title,content) => apply(title,content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layout.scala.html
                  HASH: a1909352d9e7b84ad659cfee458c418af118c197
                  MATRIX: 729->1|847->31|875->34|898->49|928->71|945->80|971->86
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2
                  -- GENERATED --
              */
          