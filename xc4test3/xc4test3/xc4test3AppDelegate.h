//
//  xc4test3AppDelegate.h
//  xc4test3
//
//  Created by Guy Cole on 10/26/11.
//  Copyright 2011 Digital Burro. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MainViewController;

@interface xc4test3AppDelegate : NSObject <UIApplicationDelegate>

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain) IBOutlet MainViewController *mainViewController;

@end
