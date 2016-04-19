
package timeline.views.html

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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*1.47*/routes/*1.53*/.Assets.at("stylesheets/timeline.css")),format.raw/*1.91*/("""">

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title></title>
</head>
<body>
        <section id="cd-timeline" class="cd-container">
            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Hybrida blir stiftet</h2>
                    <p>Hybrida Linjeforening ble stiftet i 2003.</p>
                    <span class="cd-date">Jan 14</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-year">
                    <p class="cd-timeline-year">2003</p>
                </div>
                <div class="cd-timeline-content">
                    <h2>HEIHEIHEI</h2>
                </div>
            </div>

            <div>

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Hybrida Vevkom opprettet</h2>
                    <p>Hybridas Vevkomité ble opprettet, og Hyrbidas første nettside ble lansert 4.november.</p>
                    <span class="cd-date">Jan 18</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Kia begynte i Hybrida</h2>
                    <p>Alle hjerter gledet seg da Kia begynte på I&IKT</p>
                    <span class="cd-date">11.august 2014</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Endelig et kvinnelig medlem i Vevkom!</h2>
                    <p>Endelig ble et dugelige kvinnelig medlem tatt opp i vevkom</p>
                    <span class="cd-date">29. August 2014</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Title of section 5</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iusto, optio, dolorum provident rerum.</p>
                    <span class="cd-date">Feb 18</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->

            <div class="cd-timeline-block">
                <div class="cd-timeline-img cd-griff">
                    <img src="/assets/images/Griff, drop shadow.png">
                </div> <!-- cd-timeline-img -->

                <div class="cd-timeline-content">
                    <h2>Final Section</h2>
                    <p>This is the content of the last section</p>
                    <span class="cd-date">Feb 26</span>
                </div> <!-- cd-timeline-content -->
            </div> <!-- cd-timeline-block -->
        </section> <!-- cd-timeline -->

</body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/timeline/views/index.scala.html
                  HASH: 147d85464c26e9323eed3a1478fc8af554c1f002
                  MATRIX: 807->0|879->46|893->52|951->90
                  LINES: 29->1|29->1|29->1|29->1
                  -- GENERATED --
              */
          