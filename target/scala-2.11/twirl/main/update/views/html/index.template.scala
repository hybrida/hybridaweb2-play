
package update.views.html

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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Array[String],Map[String, Array[String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(folders: Array[String], contents: Map[String, Array[String]]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*2.1*/("""<style>
.thumbnail """),format.raw/*3.12*/("""{"""),format.raw/*3.13*/("""
"""),format.raw/*4.1*/("""height : 326px ;
width : 253px ;
display: inline-block;
overflow: hidden;
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/("""
"""),format.raw/*9.1*/("""</style>

<div class="container-fluid center-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="page-box space-above space-below">
                <div>
                    <p><h1>Update<sup>k</sup></h1>
                </div>
                <br>
                <p> <b>Update<sup>k</sup></b> (’/øpdeit ikå:té’/, red.anm.) er linjeforeningsavisen til Hybrida - en avis av og for Hybrider.<br>
                    <a href=""""),_display_(/*20.31*/update/*20.37*/.routes.Update.redaksjon()),format.raw/*20.63*/("""">Redaksjonen</a> har som mål å gi ut tre aviser på høstsemesteret og fire,
                    med en sommeravis i posten til de nye studentene, på
                    vårsemesteret. Avisen printes og distribueres (i all hovedsak
                    på lesesalen), og er tilgjengelig på nett for hybrider."</p>

                <p>Dersom du er alumni og ønsker å abonnere på avisen,
                    kan du sende en mail til redaktøren.</p>
                """),_display_(/*27.18*/if(models.LoginState.isValidlyLoggedIn())/*27.59*/ {_display_(Seq[Any](format.raw/*27.61*/("""
                    """),format.raw/*28.76*/("""
                    """),_display_(/*29.22*/for(folder <- folders) yield /*29.44*/ {_display_(Seq[Any](format.raw/*29.46*/("""
                        """),format.raw/*30.25*/("""<h3>"""),_display_(/*30.30*/folder),format.raw/*30.36*/("""</h3>
                        <div>
                        """),_display_(/*32.26*/if(contents.get(folder) != null)/*32.58*/ {_display_(Seq[Any](format.raw/*32.60*/("""
                            """),_display_(/*33.30*/for(thumbnail <- contents.get(folder)) yield /*33.68*/ {_display_(Seq[Any](format.raw/*33.70*/("""
                                """),format.raw/*34.33*/("""<a href=""""),_display_(/*34.43*/routes/*34.49*/.Restricted.at("innlogget", "update/" + folder + "/" + thumbnail.substring(0, thumbnail.length() - 2) + "df")),format.raw/*34.158*/("""" class="thumbnail">
                                    <img src=""""),_display_(/*35.48*/routes/*35.54*/.Restricted.at("innlogget", "update/" + folder + "/" + thumbnail)),format.raw/*35.119*/("""" alt = "thumbnail"/>
                                </a>
                            """)))}),format.raw/*37.30*/("""
                        """)))}),format.raw/*38.26*/("""
                        """),format.raw/*39.25*/("""</div>
                    """)))}),format.raw/*40.22*/("""
                """)))}/*41.19*/else/*41.24*/{_display_(Seq[Any](format.raw/*41.25*/("""
                    """),format.raw/*42.21*/("""<a href=""""),_display_(/*42.31*/sso/*42.34*/.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path())),format.raw/*42.106*/("""">Logg inn</a>
                """)))}),format.raw/*43.18*/("""
                """),format.raw/*44.17*/("""<div style="clear:both"></div>
            </div>
        </div>
    </div>
</div>"""))}
  }

  def render(folders:Array[String],contents:Map[String, Array[String]]): play.twirl.api.HtmlFormat.Appendable = apply(folders,contents)

  def f:((Array[String],Map[String, Array[String]]) => play.twirl.api.HtmlFormat.Appendable) = (folders,contents) => apply(folders,contents)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/update/views/index.scala.html
                  HASH: 50d2ef855219f29a7e198b2b1c21737362add252
                  MATRIX: 764->1|914->63|942->65|989->85|1017->86|1045->88|1149->166|1176->167|1204->169|1705->643|1720->649|1767->675|2263->1144|2313->1185|2353->1187|2403->1264|2453->1287|2491->1309|2531->1311|2585->1337|2617->1342|2644->1348|2734->1411|2775->1443|2815->1445|2873->1476|2927->1514|2967->1516|3029->1550|3066->1560|3081->1566|3212->1675|3308->1744|3323->1750|3410->1815|3531->1905|3589->1932|3643->1958|3703->1987|3741->2007|3754->2012|3793->2013|3843->2035|3880->2045|3892->2048|3986->2120|4050->2153|4096->2171
                  LINES: 26->1|29->1|30->2|31->3|31->3|32->4|36->8|36->8|37->9|48->20|48->20|48->20|55->27|55->27|55->27|56->28|57->29|57->29|57->29|58->30|58->30|58->30|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|63->35|65->37|66->38|67->39|68->40|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|72->44
                  -- GENERATED --
              */
          