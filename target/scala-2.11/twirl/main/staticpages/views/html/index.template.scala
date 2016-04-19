
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<nav class="transparent-box" id="sidebar">
    <ul class="nav nav-pills nav-stacked">
        <li><a class="page-link" href="#1">Hybrida</a></li>
        <li><a class="page-link" href="#2">Styret</a></li>
        <li><a class="page-link" href="#3">Hybridas Komitéer</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
                <li><a href=""""),_display_(/*7.31*/staticpages/*7.42*/.routes.About.vevkom()),format.raw/*7.64*/("""">VevKom</a></li>
                <li><a href=""""),_display_(/*8.31*/staticpages/*8.42*/.routes.About.bedkom()),format.raw/*8.64*/("""">BedKom</a></li>
                <li><a href=""""),_display_(/*9.31*/staticpages/*9.42*/.routes.About.arrkom()),format.raw/*9.64*/("""">ArrKom</a></li>
                <li><a href=""""),_display_(/*10.31*/staticpages/*10.42*/.routes.About.jentekom()),format.raw/*10.66*/("""">JenteKom</a></li>
                <li><a href=""""),_display_(/*11.31*/staticpages/*11.42*/.routes.About.redaksjonen()),format.raw/*11.69*/("""">Redaksjonen</a></li>
            </ul>
        </li>
        <li><a class="page-link" href="#4">Update</a></li>
        <li><a class="page-link" href="#5">Informasjon til nye studenter</a></li>
        <li><a class="page-link" href="#6">Griffens Orden</a></li>
        <li>
            <a class="page-link" href="#7">Kontaktinformasjon</a>
            <ul class="nav nav-pills nav-stacked sub-nav">
                <li><a href="#adresse">Adresse</a></li>
            </ul>
        </li>
    </ul>
</nav>

<div class="container-fluid center-container">
    <div class="row">
        <div class="col-xs-12 space-below">
            <div class="pages">
                <section id="hybrida">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Hybrida"></a>
                        <div id="grifflogo-container">
                            <section id="grifflogo">
                                <img src=""""),_display_(/*35.44*/controllers/*35.55*/.routes.Assets.at("/images/logo_big_transparent_shadow.png")),format.raw/*35.115*/("""" />
                            </section>
                        </div>
                        <p>
                            <b>Hybrida</b> er linjeforeningen for studieprogrammet <b>Ingeniørvitenskap og IKT</b> ved NTNU i Trondheim.
                            Foreningens formål er å fremme samhold og kameratskap innad på studieprogrammet ved blant annet å
                            avholde arrangementer av både sosial og faglig karakter.
                        </p>
                    </div>
                </section>

                <section id="styret">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Styret"></a>
                        <a class="bildelink" href=""""),_display_(/*49.53*/staticpages/*49.64*/.routes.About.styret()),format.raw/*49.86*/("""">
                            <div class="bildetekst" >Styret i Hybrida</div>
                        </a>
                    </div>
                </section>

                <section id="komiteer">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Komitéer"></a>
                        <a class="link" href=""""),_display_(/*58.48*/staticpages/*58.59*/.routes.About.styret()),format.raw/*58.81*/("""">
                            <h2><p> Hybridas Komitéer </p></h2>
                            <p>Vevkom <br>BedKom <br>ArrKom<br>Jentekom<br>Redaksjonen</p>
                        </a>
                    </div>
                </section>

                <section id="update">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Update"></a>
                        <a class="bildelink" href=""""),_display_(/*68.53*/update/*68.59*/.routes.Update.index()),format.raw/*68.81*/("""">
                            <div class="bildetekst">Update<sup>k</sup></div>
                        </a>
                    </div>
                </section>

                <section id="student">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Student"></a>
                        <a class="bildelink" href=""""),_display_(/*77.53*/staticpages/*77.64*/.routes.About.newStudent()),format.raw/*77.90*/("""">
                            <div class="bildetekst">Ny Student?</div>
                        </a>
                    </div>
                </section>

                <section id="griffensorden">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="GriffensOrden"></a>
                        <a class="bildelink" href=""""),_display_(/*86.53*/griffensorden/*86.66*/.routes.GriffensOrden.index()),format.raw/*86.95*/("""">
                            <div class="bildetekst">Griffens Orden</div>
                        </a>
                    </div>
                </section>

                <section id="kontaktinfo">
                    <div class="section-box drop-shadow space-above">
                        <a href="#" name="Kontaktinfo"></a>
                        <p> Kontakinformasjon </p>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/index.scala.html
                  HASH: f97f7aa6e99b8205b4ee4e8bf35742c53bef9793
                  MATRIX: 810->0|1201->365|1220->376|1262->398|1337->447|1356->458|1398->480|1473->529|1492->540|1534->562|1610->611|1630->622|1675->646|1753->697|1773->708|1821->735|2840->1727|2860->1738|2942->1798|3733->2562|3753->2573|3796->2595|4209->2981|4229->2992|4272->3014|4766->3481|4781->3487|4824->3509|5241->3899|5261->3910|5308->3936|5730->4331|5752->4344|5802->4373
                  LINES: 29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|63->35|63->35|63->35|77->49|77->49|77->49|86->58|86->58|86->58|96->68|96->68|96->68|105->77|105->77|105->77|114->86|114->86|114->86
                  -- GENERATED --
              */
          