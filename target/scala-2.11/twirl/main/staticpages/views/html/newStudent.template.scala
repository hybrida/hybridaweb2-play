
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
object newStudent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.1*/("""<div class="article-bg" style="background-image: url('"""),_display_(/*2.56*/routes/*2.62*/.Assets.at("images/nys.png")),format.raw/*2.90*/("""')">
<div class="container-fluid center-container">
		<div class="row">
            <div class="col-sm-8 col-sm-offset-2 col-lg-6 col-lg-offset-3">
                <div class="transparent-box rounded space-above space-below">
                    <div class="row">
                            <div class="col-xs-12">
                                <h1 class="text-center"> NY STUDENT? </h1>
                            </div>

                    </div>
                    <div class="row">
                            <div class="col-xs-6 col-xs-offset-3">
                                <hr>
                            </div>
                    </div>

                    <div class="row">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/newStudent.scala.html
                  HASH: 20d48d398a282fa83d8e0faee344a0dd259431cd
                  MATRIX: 815->2|896->57|910->63|958->91
                  LINES: 29->2|29->2|29->2|29->2
                  -- GENERATED --
              */
          