# ElasticDragDismissLayout
让布局支持上下滑动消失

# 截图
![](https://github.com/chrissen0814/ElasticDragDismissLayout/blob/master/screenshot/elastic.gif)

# 使用
1. 配置

   项目build.gradle中添加：

   ```java
   allprojects {
   		repositories {
   			...
   			maven { url 'https://jitpack.io' }
   		}
   	}
   ```

   module的build.gradle中添加：

   ```java
   dependencies {
   	        implementation 'com.github.chrissen0814:ElasticDragDismissLayout:0.0.1'
   	}
   ```

2. 布局中添加View

   ```java
   <com.chrissen.core.ElasticDragDismissFrameLayout
       xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:id="@+id/elastic_layout"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".DetailActivity"
       app:dragDismissDistance="112dp"
       app:dragDismissScale="0.95">
   
      ......
   
   </com.chrissen.core.ElasticDragDismissFrameLayout>
   ```

   注意：子布局需要实现NestedScrollingChild2接口，官方组件中已经实现了该接口的组件有：RecyclerView、NestedScrollView等，否则没有效果。

3. 在代码中设置监听回调

   ```java
   mLayout.addListener(new ElasticDragDismissFrameLayout.SystemChromeFader(this){
   
               @Override
               public void onDrag(float elasticOffset, float elasticOffsetPixels, float rawOffset, float rawOffsetPixels) {
                   super.onDrag(elasticOffset, elasticOffsetPixels, rawOffset, rawOffsetPixels);
                   //do something
               }
   
               @Override
               public void onDragDismissed() {
                   super.onDragDismissed();
                   //do something
               }
           });
   ```

## 属性设置

| 属性名              | 作用                 | 备注                                                         |
| ------------------- | -------------------- | ------------------------------------------------------------ |
| dragDismissScale    | 滑动时布局的缩放比例 | 值为1时不缩放                                                |
| dragDismissDistance | 滑动消失的距离       | 当dragDismissFraction>0时，dragDismissDistance = height * dragDismissFraction; |
| dragDismissFraction | 滑动消失的比例       | 大于0时，会影响dragDismissDistance的设置                     |
| dragElasticity      | drag回弹比例设置     | 影响回调效果                                                 |

## 鸣谢
https://github.com/nickbutcher/plaid
