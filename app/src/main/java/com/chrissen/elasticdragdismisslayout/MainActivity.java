package com.chrissen.elasticdragdismisslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chrissen.elasticdragdismisslayout.adapter.ContentAdapter;
import com.chrissen.elasticdragdismisslayout.bean.ContentBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ContentAdapter mContentAdapter;
    private List<ContentBean> mContentBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_content);
        ContentBean contentBean1 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111617160.jpg", "这是一张伪色红外照片。2018年10月，在拜科努尔航天发射场，联盟号MS-10宇宙飞船载着NASA宇航员Nick Hague和俄罗斯宇航员Alexey Ovchinin正在升空。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean2 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111617251.jpg", "2011年7月7日，亚特兰蒂斯号航天飞机在等待发射，接下来它将飞往国际空间站执行12天任务。这是这个航天飞机项目的最后一次飞行。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean3 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111618458.jpg", "2012年10月22日，在拜科努尔发射场发射台，一位东正教牧师正站在联盟号火箭旁，为媒体工作人员祈福。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean4 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111618876.jpg", "2012年5月13日，火车把联盟号TMA-04M航天飞船载到了哈萨克斯坦拜科努尔发射场的发射台。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean5 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111618414.jpg", "这是一张长曝光照片。2018年8月12日，联合发射联盟公司发射了德尔塔IV型重型火箭，上面载着NASA的帕克太阳探测器，用以研究太阳。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean6 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111618907.jpg", "2010年4月5日，佛罗里达州，发现号航天飞机发射后，工人们纷纷离开卡纳维拉尔角发射控制中心。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean7 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111619839.jpg", "2011年3月19日，在华盛顿特区林肯纪念堂，一轮超级月亮缓缓升起。 摄影：NASA/BILL INGALLS");
        ContentBean contentBean8 = new ContentBean("http://image.ngchina.com.cn/2019/0221/20190221111619493.jpg", "2012年4月20日，华盛顿杜勒斯国际机场，在NASA的747航天飞机载机上，可以看到企业号航天飞机。 摄影：NASA/BILL INGALLS");
        mContentBeanList.add(contentBean1);
        mContentBeanList.add(contentBean2);
        mContentBeanList.add(contentBean3);
        mContentBeanList.add(contentBean4);
        mContentBeanList.add(contentBean5);
        mContentBeanList.add(contentBean6);
        mContentBeanList.add(contentBean7);
        mContentBeanList.add(contentBean8);
        mContentAdapter = new ContentAdapter(this, mContentBeanList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mContentAdapter);
    }
}
