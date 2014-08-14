PacPie Chart
=========

![banner](http://185.14.185.122/github/pacpie.png)

PacPie is a small library to generate Pie Chart as an ImageView (will be different soon).

  - Easy customization
  - Use your colors for fill & stroke
  - Add percents
  - Add a background color if needed
  - Hide or show pie chart with animation (comming soon)

Version
----
1.0

Compatibility
----
Should be compatible with all SDK version (back to 1).

Preview
---

![preview](http://185.14.185.122/github/pacpie_preview.png)

Usage
----

Define your pie slices List

```java
List<PieDetailsItem> piedata=new ArrayList<PieDetailsItem>(0);
int maxCount=0;
int itemCount=0;
```

Create slices (here it's from a custom object named Answer)

```java
itemCount = getPercent();

PieDetailsItem item = new PieDetailsItem();
item.count = itemCount;
item.label = answer.getTextAnswer();
item.color = Color.parseColor(color);
piedata.add(item);
maxCount=maxCount+itemCount;
```

Then, create the pie object


```java
pie = (ImageView)findViewById(R.id.pie);
Bitmap mBaggroundImage=Bitmap.createBitmap(200,200,Bitmap.Config.ARGB_8888);
PieChart piechart=new PieChart(this);
piechart.setLayoutParams(new LayoutParams(200,200));
piechart.setGeometry(200, 200, 2, 2, 2, 2, 2130837504);
piechart.setSkinparams(getResources().getColor(android.R.color.transparent));
piechart.setData(piedata, maxCount);
piechart.invalidate();
piechart.draw(new Canvas(mBaggroundImage));
pie.setImageBitmap(mBaggroundImage);
```

License
---

```text
The MIT License (MIT)

Copyright (c) 2014 Fernandez Anthony

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```

