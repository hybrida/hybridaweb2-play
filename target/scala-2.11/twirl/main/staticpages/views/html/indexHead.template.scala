
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
object indexHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),format.raw/*2.1*/("""<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.Assets.at("onepage-scroll/jquery.onepage-scroll.js")),format.raw/*2.97*/(""""></script>
<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.47*/routes/*3.53*/.Assets.at("onepage-scroll/onepage-scroll.css")),format.raw/*3.100*/("""">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*4.47*/routes/*4.53*/.Assets.at("stylesheets/abouthybrida.css")),format.raw/*4.95*/("""">
<script type="text/javascript">
    $(document).ready(function()"""),format.raw/*6.33*/("""{"""),format.raw/*6.34*/("""
        """),format.raw/*7.9*/("""var openNav = $();
        var sidebar = $("#sidebar");
        sidebar.find(".sub-nav").each(function()"""),format.raw/*9.49*/("""{"""),format.raw/*9.50*/("""
            """),format.raw/*10.13*/("""$(this).data("height", $(this).height());
            $(this).height(0);
        """),format.raw/*12.9*/("""}"""),format.raw/*12.10*/(""");
        sidebar.find(".page-link[href*='#1']").first().focus();

        var pages = $(".pages");
        pages.onepage_scroll("""),format.raw/*16.30*/("""{"""),format.raw/*16.31*/("""
                """),format.raw/*17.17*/("""sectionContainer: ".pages > section",
                pagination: true,
                loop: false,
                updateURL: true,
                responsiveFallback: 768,
                beforeMove: function(index) """),format.raw/*22.45*/("""{"""),format.raw/*22.46*/("""
                    """),format.raw/*23.21*/("""var link = sidebar.find(".page-link[href*='#" + index + "']").first();
                    link.focus();
                    var nav = link.next(".sub-nav");
                    if(!openNav.is(nav)) """),format.raw/*26.42*/("""{"""),format.raw/*26.43*/("""
                        """),format.raw/*27.25*/("""if(openNav.size() > 0) """),format.raw/*27.48*/("""{"""),format.raw/*27.49*/("""
                            """),format.raw/*28.29*/("""openNav.animate("""),format.raw/*28.45*/("""{"""),format.raw/*28.46*/(""""height": 0"""),format.raw/*28.57*/("""}"""),format.raw/*28.58*/(""");
                            openNav = $();
                        """),format.raw/*30.25*/("""}"""),format.raw/*30.26*/("""if(nav.size() > 0) """),format.raw/*30.45*/("""{"""),format.raw/*30.46*/("""
                            """),format.raw/*31.29*/("""nav.animate("""),format.raw/*31.41*/("""{"""),format.raw/*31.42*/(""""height": nav.data("height")"""),format.raw/*31.70*/("""}"""),format.raw/*31.71*/(""");
                            openNav = nav;
                        """),format.raw/*33.25*/("""}"""),format.raw/*33.26*/("""
                    """),format.raw/*34.21*/("""}"""),format.raw/*34.22*/("""
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/("""
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/(""");
        sidebar.find(".page-link").click(function()"""),format.raw/*37.52*/("""{"""),format.raw/*37.53*/("""
            """),format.raw/*38.13*/("""pages.moveTo(parseInt($(this).attr("href").substr(1)));
        """),format.raw/*39.9*/("""}"""),format.raw/*39.10*/(""");

    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/(""");
</script>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/indexHead.scala.html
                  HASH: d7fdd299541450f223f82562d06bdddd55a1b4fe
                  MATRIX: 732->1|821->3|849->5|912->42|926->48|999->101|1084->160|1098->166|1166->213|1242->263|1256->269|1318->311|1414->380|1442->381|1478->391|1611->497|1639->498|1681->512|1791->595|1820->596|1982->730|2011->731|2057->749|2309->973|2338->974|2388->996|2618->1198|2647->1199|2701->1225|2752->1248|2781->1249|2839->1279|2883->1295|2912->1296|2951->1307|2980->1308|3080->1380|3109->1381|3156->1400|3185->1401|3243->1431|3283->1443|3312->1444|3368->1472|3397->1473|3497->1545|3526->1546|3576->1568|3605->1569|3651->1587|3680->1588|3717->1598|3746->1599|3829->1654|3858->1655|3900->1669|3992->1734|4021->1735|4058->1745|4086->1746
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|35->7|37->9|37->9|38->10|40->12|40->12|44->16|44->16|45->17|50->22|50->22|51->23|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|61->33|61->33|62->34|62->34|63->35|63->35|64->36|64->36|65->37|65->37|66->38|67->39|67->39|69->41|69->41
                  -- GENERATED --
              */
          