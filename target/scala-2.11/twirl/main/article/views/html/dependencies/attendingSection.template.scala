
package article.views.html.dependencies

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
object attendingSection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(event: Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<h6 class="top-text">Påmeldte</h6>
"""),_display_(/*4.2*/if(models.LoginState.isValidlyLoggedIn)/*4.41*/ {_display_(Seq[Any](format.raw/*4.43*/("""
    """),format.raw/*5.5*/("""<div class="col-md-12">
    """),_display_(/*6.6*/for(i <- 1 to 5) yield /*6.22*/ {_display_(Seq[Any](format.raw/*6.24*/("""
        """),format.raw/*7.9*/("""<div class="row">
            <div class="col-md-1">
            """),_display_(/*9.14*/event/*9.19*/.getJoinedSpecificClass(i).size),format.raw/*9.50*/("""
            """),format.raw/*10.13*/("""</div>
            <div class="col-md-11">
                <p onclick="$ ( '.showhide"""),_display_(/*12.44*/i),format.raw/*12.45*/("""' ).toggle ( ) ;" style="cursor: pointer;"> Klasse """),_display_(/*12.97*/i/*12.98*/.toString),format.raw/*12.107*/(""" """),format.raw/*12.108*/("""</p>
            </div>
            <div style="display: none" class="showhide"""),_display_(/*14.56*/i),format.raw/*14.57*/("""" id="showhide"""),_display_(/*14.72*/i),format.raw/*14.73*/("""" name="showhide"""),_display_(/*14.90*/i),format.raw/*14.91*/("""">
            """),_display_(/*15.14*/for(j <- event.getJoinedUsers) yield /*15.44*/{_display_(Seq[Any](format.raw/*15.45*/("""
                """),format.raw/*16.17*/("""<div class="row" style="margin-left: 1%">
                    <div class="col-md-1">
                        <a href=""""),_display_(/*18.35*/profile/*18.42*/.routes.Profile.index(j.getUsername)),format.raw/*18.78*/("""" class="thumbnail">
                            <img src=""""),_display_(/*19.40*/j/*19.41*/.getProfilePictureWithFallBackOnDefault),format.raw/*19.80*/("""" alt="profilepic for """),_display_(/*19.103*/j/*19.104*/.getName),format.raw/*19.112*/("""" width="30px">
                        </a>
                    </div>
                    <div class="col-md-11">
                        <strong>"""),_display_(/*23.34*/j/*23.35*/.getNameLink),format.raw/*23.47*/("""</strong>
                    </div>
                </div>
            """)))}),format.raw/*26.14*/("""
            """),format.raw/*27.13*/("""</div>
        </div>
    """)))}),format.raw/*29.6*/("""
    """),format.raw/*30.5*/("""</div>
""")))}/*31.2*/else/*31.6*/{_display_(Seq[Any](format.raw/*31.7*/("""
    """),format.raw/*32.5*/("""<p>Logg inn for å se hvem som er påmeldt</p>
""")))}))}
  }

  def render(event:Event): play.twirl.api.HtmlFormat.Appendable = apply(event)

  def f:((Event) => play.twirl.api.HtmlFormat.Appendable) = (event) => apply(event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/attendingSection.scala.html
                  HASH: 4dfb89e8264b4cdf2652d4fabb84677f232e9f27
                  MATRIX: 754->1|856->15|886->19|948->56|995->95|1034->97|1066->103|1121->133|1152->149|1191->151|1227->161|1321->229|1334->234|1385->265|1427->279|1542->367|1564->368|1643->420|1653->421|1684->430|1714->431|1822->512|1844->513|1886->528|1908->529|1952->546|1974->547|2018->564|2064->594|2103->595|2149->613|2297->734|2313->741|2370->777|2458->838|2468->839|2528->878|2579->901|2590->902|2620->910|2800->1063|2810->1064|2843->1076|2950->1152|2992->1166|3051->1195|3084->1201|3111->1210|3123->1214|3161->1215|3194->1221
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|33->5|34->6|34->6|34->6|35->7|37->9|37->9|37->9|38->10|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|51->23|51->23|51->23|54->26|55->27|57->29|58->30|59->31|59->31|59->31|60->32
                  -- GENERATED --
              */
          