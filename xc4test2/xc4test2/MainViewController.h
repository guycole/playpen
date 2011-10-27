//
//  MainViewController.h
//  xc4test2
//
//  Created by Guy Cole on 10/26/11.
//  Copyright 2011 Digital Burro. All rights reserved.
//

#import "FlipsideViewController.h"

#import <CoreData/CoreData.h>

@interface MainViewController : UIViewController <FlipsideViewControllerDelegate>

- (IBAction)showInfo:(id)sender;

@property (nonatomic, retain) NSManagedObjectContext *managedObjectContext;

@end
