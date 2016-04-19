
package admintools.views.html

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
object adminLayout extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, content: Html, notIndex: Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.51*/("""

"""),_display_(/*3.2*/layoutWithHead(title)/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    """),format.raw/*4.5*/("""<div class="container-fluid center-container space-above">
        <div class="row space-below">
            <div class="col-xs-12">
                <div class="page-box">
                    <div class="row">
                        <div class="col-xs-12">
                            """),_display_(/*10.30*/if(notIndex)/*10.42*/ {_display_(Seq[Any](format.raw/*10.44*/("""
                                """),format.raw/*11.33*/("""<div class="buttons">
                                    <a class="pull-right btn btn-primary" href=""""),_display_(/*12.82*/admintools/*12.92*/.routes.Admin.index),format.raw/*12.111*/("""">Tilbake</a>
                                </div>
                            """)))}),format.raw/*14.30*/("""
                            """),format.raw/*15.29*/("""<h5 class="top-text">Admin</h5>
                        </div>
                    </div>
                    """),_display_(/*18.22*/content),format.raw/*18.29*/("""
                """),format.raw/*19.17*/("""</div>
            </div>
        </div>
    </div>
""")))}/*23.2*/ {_display_(Seq[Any](format.raw/*23.4*/("""
""")))}),format.raw/*24.2*/("""
"""))}
  }

  def render(title:String,content:Html,notIndex:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(title,content,notIndex)

  def f:((String,Html,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (title,content,notIndex) => apply(title,content,notIndex)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/adminLayout.scala.html
                  HASH: a335affd2557678f8914f3059c6d9ca170169bc6
                  MATRIX: 753->1|890->50|920->55|949->76|988->78|1020->84|1340->377|1361->389|1401->391|1463->425|1594->529|1613->539|1654->558|1769->642|1827->672|1968->786|1996->793|2042->811|2117->868|2156->870|2189->873
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|38->10|38->10|38->10|39->11|40->12|40->12|40->12|42->14|43->15|46->18|46->18|47->19|51->23|51->23|52->24
                  -- GENERATED --
              */
          