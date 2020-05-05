package com.example.bestuidemo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_fruit.*

class FruitActivity : AppCompatActivity() {

    companion object {
        val FRUIT_NAME = "fruit_name"
        val FRUIT_IAMGE_ID = "fruit_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        var intent = intent
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var fruitName = intent.getStringExtra(FRUIT_NAME)
        var fruitImageId = intent.getIntExtra(FRUIT_IAMGE_ID, 0)
        collapsing_toolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(fruit_image_ivew)
        fruit_content_text.text = generateFruitContent(fruitName)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }

    fun generateFruitContent(name: String): String {
        var sb = StringBuilder()
        if (name.equals("Cerasus pseudocerasus")) {
            for (i in 0..10) {
                sb.append(
                    "生于山坡阳处或沟边，常栽培，海拔300-600米\n樱桃是喜光、喜温、喜湿、喜肥的果树，适合在年均气温10-12℃，年降\n" +
                            " 水量600-700mm，年日照时数2600-2800h以上的气候条件下生长。日平均气温高于10℃的时间在150-200d，" +
                            "冬季极端最低温度不低于-20℃的地方都能生长良好，正常结果。若当地有霜害，樱桃园地可选择在春季温度" +
                            "上升缓慢，空气流通的西北坡。考虑到樱桃根系分布浅易风倒，园地以在不受风害地段为宜，土壤以土质疏松、" +
                            "土层深厚的沙壤土为佳"
                )
            }

        } else
            if (name.equals("Citrus maxima (Burm) Merr")) {
                for (i in 0..10) {
                    sb.append(
                        "为芸香科柑橘属乔木。嫩枝、叶背、花梗、花萼及子房均被柔毛，嫩叶通常暗紫红色，嫩枝扁且有棱" +
                                "。叶质颇厚，色浓绿，阔卵形或椭圆形；总状花序，有时兼有腋生单花；花蕾淡紫红色，稀乳白色；" +
                                "花萼不规则5-3浅裂；花柱粗长，柱头略较子房大。果圆球形，扁圆形，梨形或阔圆锥状，横径通常10厘米以上；" +
                                "种子多达200余粒，亦有无子的，形状不规则，通常近似长方形；子叶乳白色，单胚。花期4-5月，果期9-12月。"
                    )
                }
            } else if (name.equals("Fragaria × ananassa Duch")) {
                for (i in 0..10) {
                    sb.append(
                        "多年生草本植物。高10-40厘米，茎低于叶或近相等，密被开展黄色柔毛。叶三出，小叶具短柄，" +
                                "质地较厚，倒卵形或菱形，上面深绿色，几无毛，下面淡白绿色，疏生毛，沿脉较密；叶柄密被开" +
                                "展黄色柔毛。聚伞花序，花序下面具一短柄的小叶；花两性；萼片卵形，比副萼片稍长；花瓣白色，" +
                                "近圆形或倒卵椭圆形。聚合果大，宿存萼片直立，紧贴于果实；瘦果尖卵形，光滑。花期4-5月，果期6-7月"
                    )
                }
            }

        return sb.toString()

    }
}
