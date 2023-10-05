<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 필터 화면 > 개별 타이틀</description>
   <name>txt_filter_single_title</name>
   <tag></tag>
   <elementGuidId>9135d669-a0ef-407c-86da-bde1c60763f0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/singleFilterTitle</value>
      <webElementGuid>6a4d04ed-79c6-4767-ba6c-85595593f42d</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>330032d0-aaa7-4356-a9a2-13f2a99dc63a</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/singleFilterTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
