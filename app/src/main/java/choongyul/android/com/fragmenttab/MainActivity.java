package choongyul.android.com.fragmenttab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    // 탭 및 페이저 속성 정의
    final int TAB_COUNT = 4;
    OneFragment one;
    TwoFragment two;
    ThreeFragment three;
    FourFragment four;
//    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트 init
        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        four = new FourFragment();

        //탭 레이아웃 정의
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab( tabLayout.newTab().setText("계산기"));
        tabLayout.addTab( tabLayout.newTab().setText("단위변환"));
        tabLayout.addTab( tabLayout.newTab().setText("검색"));
        tabLayout.addTab( tabLayout.newTab().setText("현재위치"));

        //프래그먼트 페이저 작성
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        //아답터 생성
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        //아답터 세팅
        viewPager.setAdapter(adapter);

        // 1. 페이저가 변경 되었을때 탭을 바꿔주는 리스너
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // 2. 탭이 변경되었을 때 페이지를 바꿔주는 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0: fragment = one; break;
                case 1: fragment = two; break;
                case 2: fragment = three; break;
                case 3: fragment = four; break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }
}
