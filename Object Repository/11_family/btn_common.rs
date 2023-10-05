<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족관리 > 공유계정 추가 > [공유받은 초대코드 입력하기]</description>
   <name>btn_common</name>
   <tag></tag>
   <elementGuidId>b19c83bd-2300-4bd6-bf07-6c36a7218c61</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tvCommonButtonView</value>
      <webElementGuid>b7fd7119-e81b-454a-9500-bc84a9a250fa</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>a9a22dd5-222f-4faa-b2f0-047b2778fbb0</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tvCommonButtonView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
