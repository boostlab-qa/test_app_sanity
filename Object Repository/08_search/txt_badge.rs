<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 검색결과 > 뱃지</description>
   <name>txt_badge</name>
   <tag></tag>
   <elementGuidId>1074e2df-77d8-4a9b-b0ff-b3a4387f0ab7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/badgeTextView</value>
      <webElementGuid>22903c0e-4f21-4a38-803a-22be11391cb8</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>1d3739db-7f64-4dd4-80b1-352b6068a980</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/badgeTextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
