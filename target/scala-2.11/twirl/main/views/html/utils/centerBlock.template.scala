
package views.html.utils

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
object centerBlock extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.14*/("""
"""),format.raw/*2.1*/("""<div class="absolute_center">
    """),_display_(/*3.6*/data),format.raw/*3.10*/("""
"""),format.raw/*4.1*/("""</div>"""))}
  }

  def render(data:Html): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/utils/centerBlock.scala.html
                  HASH: 1a226c0f52b75a027e1e75857ac144181667dbd6
                  MATRIX: 733->1|833->13|861->15|922->51|946->55|974->57
                  LINES: 26->1|29->1|30->2|31->3|31->3|32->4
                  -- GENERATED --
              */
          