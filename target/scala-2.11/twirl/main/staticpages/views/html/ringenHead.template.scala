
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
object ringenHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),format.raw/*2.1*/("""<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.Assets.at("onepage-scroll/jquery.onepage-scroll.min.js")),format.raw/*2.101*/(""""></script>
<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.47*/routes/*3.53*/.Assets.at("onepage-scroll/onepage-scroll.css")),format.raw/*3.100*/("""">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*4.47*/routes/*4.53*/.Assets.at("stylesheets/iktringen.css")),format.raw/*4.92*/("""">
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
                beforeMove: function(index) """),format.raw/*21.45*/("""{"""),format.raw/*21.46*/("""
                    """),format.raw/*22.21*/("""var link = sidebar.find(".page-link[href*='#" + index + "']").first();
                    link.focus();
                    var nav = link.next(".sub-nav");
                    if(!openNav.is(nav)) """),format.raw/*25.42*/("""{"""),format.raw/*25.43*/("""
                        """),format.raw/*26.25*/("""if(openNav.size() > 0) """),format.raw/*26.48*/("""{"""),format.raw/*26.49*/("""
                            """),format.raw/*27.29*/("""openNav.animate("""),format.raw/*27.45*/("""{"""),format.raw/*27.46*/(""""height": 0"""),format.raw/*27.57*/("""}"""),format.raw/*27.58*/(""");
                            openNav = $();
                        """),format.raw/*29.25*/("""}"""),format.raw/*29.26*/("""if(nav.size() > 0) """),format.raw/*29.45*/("""{"""),format.raw/*29.46*/("""
                            """),format.raw/*30.29*/("""nav.animate("""),format.raw/*30.41*/("""{"""),format.raw/*30.42*/(""""height": nav.data("height")"""),format.raw/*30.70*/("""}"""),format.raw/*30.71*/(""");
                            openNav = nav;
                        """),format.raw/*32.25*/("""}"""),format.raw/*32.26*/("""
                    """),format.raw/*33.21*/("""}"""),format.raw/*33.22*/("""
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/("""
        """),format.raw/*35.9*/("""}"""),format.raw/*35.10*/(""");
        sidebar.find(".page-link").click(function()"""),format.raw/*36.52*/("""{"""),format.raw/*36.53*/("""
            """),format.raw/*37.13*/("""pages.moveTo(parseInt($(this).attr("href").substr(1)));
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""");

    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""");
</script>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/ringenHead.scala.html
                  HASH: 8c23d7322f40c25095c5e4355ec005a273148783
                  MATRIX: 733->1|822->3|850->5|913->42|927->48|1005->105|1090->164|1104->170|1172->217|1248->267|1262->273|1321->312|1417->381|1445->382|1481->392|1614->498|1642->499|1684->513|1794->596|1823->597|1985->731|2014->732|2060->750|2270->932|2299->933|2349->955|2579->1157|2608->1158|2662->1184|2713->1207|2742->1208|2800->1238|2844->1254|2873->1255|2912->1266|2941->1267|3041->1339|3070->1340|3117->1359|3146->1360|3204->1390|3244->1402|3273->1403|3329->1431|3358->1432|3458->1504|3487->1505|3537->1527|3566->1528|3612->1546|3641->1547|3678->1557|3707->1558|3790->1613|3819->1614|3861->1628|3953->1693|3982->1694|4019->1704|4047->1705
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|35->7|37->9|37->9|38->10|40->12|40->12|44->16|44->16|45->17|49->21|49->21|50->22|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|60->32|60->32|61->33|61->33|62->34|62->34|63->35|63->35|64->36|64->36|65->37|66->38|66->38|68->40|68->40
                  -- GENERATED --
              */
          