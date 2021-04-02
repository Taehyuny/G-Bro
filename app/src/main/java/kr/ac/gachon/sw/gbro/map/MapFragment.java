package kr.ac.gachon.sw.gbro.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;

import kr.ac.gachon.sw.gbro.base.BaseFragment;
import kr.ac.gachon.sw.gbro.databinding.FragmentMapBinding;

public class MapFragment extends BaseFragment<FragmentMapBinding> implements OnMapReadyCallback {
    @Override
    protected FragmentMapBinding getBinding() {
        return FragmentMapBinding.inflate(getLayoutInflater());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setMap();

        return getBinding().getRoot();
    }

    private void setMap() {
        FragmentManager fragmentManager = getChildFragmentManager();
        com.naver.maps.map.MapFragment mapFragment = (com.naver.maps.map.MapFragment) fragmentManager.findFragmentById(binding.map.getId());

        if(mapFragment == null) {
            NaverMapOptions options = new NaverMapOptions()
                    .camera(new CameraPosition(new LatLng(37.45082183610419, 127.12877229523757), 16))
                    .locationButtonEnabled(true);
            mapFragment = com.naver.maps.map.MapFragment.newInstance(options);
            fragmentManager.beginTransaction().add(binding.map.getId(), mapFragment).commit();
        }
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

    }
}