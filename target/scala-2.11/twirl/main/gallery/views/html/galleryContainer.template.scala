
package gallery.views.html

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
object galleryContainer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[GalleryImage],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(images: List[GalleryImage]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*3.1*/("""<div class="gallery">
    """),_display_(/*4.6*/for(image <- images) yield /*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
        """),format.raw/*5.9*/("""<div
            class="imageWrapper"
            data-title=""""),_display_(/*7.26*/image/*7.31*/.getTitle()),format.raw/*7.42*/(""""
            data-desc=""""),_display_(/*8.25*/image/*8.30*/.getDescription()),format.raw/*8.47*/(""""
            data-score=""""),_display_(/*9.26*/image/*9.31*/.getScore()),format.raw/*9.42*/(""""
            data-id=""""),_display_(/*10.23*/image/*10.28*/.getImageId()),format.raw/*10.41*/(""""
            data-uploader=""""),_display_(/*11.29*/image/*11.34*/.getUploadedBy().getFullName()),format.raw/*11.64*/(""""
            data-date=""""),_display_(/*12.25*/image/*12.30*/.getDateUploaded().format("d. MMM, yyyy")),format.raw/*12.71*/(""""
            data-orgwidth=""""),_display_(/*13.29*/image/*13.34*/.getWidth()),format.raw/*13.45*/(""""
            data-orgheight=""""),_display_(/*14.30*/image/*14.35*/.getHeight()),format.raw/*14.47*/(""""
            data-orgurl=""""),_display_(/*15.27*/image/*15.32*/.getImageURL()),format.raw/*15.46*/(""""
            data-thumburl=""""),_display_(/*16.29*/image/*16.34*/.getThumbURL()),format.raw/*16.48*/(""""
            data-thumbsize=""""),_display_(/*17.30*/image/*17.35*/.getThumbSize()),format.raw/*17.50*/(""""
        >
        </div>
    """)))}),format.raw/*20.6*/("""
"""),format.raw/*21.1*/("""</div>"""))}
  }

  def render(images:List[GalleryImage]): play.twirl.api.HtmlFormat.Appendable = apply(images)

  def f:((List[GalleryImage]) => play.twirl.api.HtmlFormat.Appendable) = (images) => apply(images)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/gallery/views/galleryContainer.scala.html
                  HASH: 6e372b109f1f43b32e933af20dc7814b4bd1409c
                  MATRIX: 754->1|870->29|900->33|953->61|988->81|1027->83|1063->93|1154->158|1167->163|1198->174|1251->201|1264->206|1301->223|1355->251|1368->256|1399->267|1451->292|1465->297|1499->310|1557->341|1571->346|1622->376|1676->403|1690->408|1752->449|1810->480|1824->485|1856->496|1915->528|1929->533|1962->545|2018->574|2032->579|2067->593|2125->624|2139->629|2174->643|2233->675|2247->680|2283->695|2348->730|2377->732
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|49->21
                  -- GENERATED --
              */
          