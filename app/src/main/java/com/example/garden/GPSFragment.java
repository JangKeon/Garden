package com.example.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GPSFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.gps_frag, container, false);

        MapView mapView = new MapView(getContext());

        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);



        //127.028002, 37.4945470
        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(37.4945470,127.028002);

        //지도의 중심점을 특정 위치로 설정 확대 레벨 설정 (값이 작을수록 더 확대된다)
        mapView.setMapCenterPoint(mapPoint,true);
        mapView.setZoomLevel(1,true);

        //marker 설정
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        //marker.setTag(0);
        marker.setMapPoint(mapPoint);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);

        return view;
    }
}
