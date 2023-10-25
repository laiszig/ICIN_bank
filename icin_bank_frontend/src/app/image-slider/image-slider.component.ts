import { Component } from '@angular/core';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css']
})
export class ImageSliderComponent {
  title= 'image-slider';

  imageSize: any = {
    width: 400, height: 400, space: 4
  }

  imageObject: Array<object> = [
    {
      image: 'assets/images/download.jpg',
      thumbImage: 'assets/images/download.jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }, {
      image: 'assets/images/download (1).jpg',
      thumbImage: 'assets/images/download (1).jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }, {
      image: 'assets/images/download (2).jpg',
      thumbImage: 'assets/images/download (2).jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }, {
      image: 'assets/images/download (3).jpg',
      thumbImage: 'assets/images/download (3).jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }, {
      image: 'assets/images/download (4).jpg',
      thumbImage: 'assets/images/download (4).jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }, {
      image: 'assets/images/download (5).jpg',
      thumbImage: 'assets/images/download (5).jpg',
      alt: 'Your Image Alt Text',
      //title: 'Image 1'
    }
];
}
